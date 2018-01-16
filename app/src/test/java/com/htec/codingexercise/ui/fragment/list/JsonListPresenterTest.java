package com.htec.codingexercise.ui.fragment.list;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htec.codingexercise.errorhandler.ErrorHandler;
import com.htec.codingexercise.network.NNetworkInfo;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.network.NetworkStateReceiverListener;
import com.htec.codingexercise.ui.fragment.list.api.APIJsonData;
import com.htec.codingexercise.ui.fragment.list.dto.DTOElement;
import com.htec.codingexercise.ui.fragment.list.utils.FileUtils;
import com.htec.codingexercise.utils.rxutils.MSchedulers;
import com.htec.codingexercise.utils.rxutils.PresenterCallbackOnResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsonListPresenterTest {

    private static final String FILE_NAME_MOCKED_JSON = "MockedData.json";

    ObjectMapper mapper = new ObjectMapper();

    private JsonListView view;
    private JsonListInteractor interactor;
    private JsonListPresenterImpl presenter;
    private ErrorHandler errorHandler;
    private APIJsonData api;
    private MSchedulers schedulers;
    private NetworkManager networkManager;

    /**
     * Do all mocks before tests.
     */
    @Before
    public void setUp() throws Exception {

        view = mock(JsonListView.class);
        errorHandler = mock(ErrorHandler.class);
        api = mock(APIJsonData.class);
        schedulers = mock(MSchedulers.class);
        networkManager = mock(NetworkManager.class);

        interactor = new JsonListInteractorImpl(errorHandler, api, schedulers);

        presenter = new JsonListPresenterImpl(view, interactor, networkManager);

        when(api.getJsonData()).thenReturn(getMockedJsonList());
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Immediately after the fragment is being loaded {@link JsonListPresenter#loadJsonData()} method should be invoked.
     */
    @Test
    public void onFragmentStartLoadJsonData() throws Exception {

        presenter.loadJsonData();

        verifyLoadingActions();

//        simulateDataLoadSuccessfully();
//        verify(view, times(1)).setData(anyList());
    }

    /**
     * Check is fragment unsubsidised from {@link NetworkManager} after {@link JsonListPresenter#onDestroy()} method is being called.
     */
    @Test
    public void onDestroyRemoveNetworkManagerListener() throws Exception {

        presenter.onDestroy();

        verify(networkManager, times(1)).removeListener(any(NetworkStateReceiverListener.class));
    }

    /**
     * After internet is back check if load data routine is re-engaged.
     */
    @Test
    public void onConnectionEstablishLoadJsonData() throws Exception {

        NNetworkInfo info = new NNetworkInfo(NNetworkInfo.State.CONNECTED);

        presenter.onNetworkChange(info);

        verifyLoadingActions();

    }

    //************ HELPER METHODS ************//

    /**
     * It should simulate engaging of {@link PresenterCallbackOnResult#onResult(Object)} ()}
     */
    private void simulateDataLoadSuccessfully() {
        doAnswer(invocation -> {
            JsonListInteractor.JsonListListener listener = (JsonListInteractor.JsonListListener) invocation.getArguments()[2];
            listener.onResult(anyList());
            return null;
        }).when(interactor).getJson(any(JsonListInteractor.JsonListListener.class));
    }

    /**
     * Checks and verifies if fragment is registered to listen for network changes and is loading animation activated.
     */
    private void verifyLoadingActions() {
        presenter.networkStatusListenerSet = false;
        verify(networkManager).addListener(any(NetworkStateReceiverListener.class));
        verify(view, times(1)).showLoadingAnimation(true);
    }

    /**
     * Returns Observable with pre-cached json data held locally.
     */
    private Observable<List<DTOElement>> getMockedJsonList() {
        List<DTOElement> list = null;
        try {
            list = mapper.readValue(FileUtils.getFileResource(FILE_NAME_MOCKED_JSON),
                    new TypeReference<List<DTOElement>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Observable.just(list);
    }
}