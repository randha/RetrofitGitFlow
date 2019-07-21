package pe.edu.cibertec.retrofitgitflow.presentation.main.presenter;

import java.util.List;

import javax.inject.Inject;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.IMainInteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.main.MainContract;

public class MainPresenter implements MainContract.IPresenter {
    MainContract.IView view;
    private final IMainInteractor interactor;

    @Inject
    public MainPresenter(IMainInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void attachView(MainContract.IView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void getAllPost() {
        view.showProgressBar();
        //view.showError("GET ALL POST");
        interactor.getAllPost(new IMainInteractor.IMainCallBack() {
            @Override
            public void onSuccess(List<Post> postList) {
                if (isViewAttached()) {
                    view.getAllPostSuccess(postList);
                    view.hideProgressBar();
                }
            }

            @Override
            public void onError(String errorMsg) {
                if (isViewAttached()) {
                    view.showError(errorMsg);
                    view.hideProgressBar();
                }
            }
        });
        // aqui usaremos un interceptor de la capa domain
    }
}
