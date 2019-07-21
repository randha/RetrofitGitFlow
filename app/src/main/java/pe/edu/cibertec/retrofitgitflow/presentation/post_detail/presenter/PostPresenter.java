package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter;

import javax.inject.Inject;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_interactor.IPostDetailInteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;

public class PostPresenter implements IPostDetailContract.IPresenter {
    IPostDetailContract.IView view;

    private final IPostDetailInteractor interactor;

    @Inject
    public PostPresenter(IPostDetailInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void attachView(IPostDetailContract.IView view) {
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
    public void getPost(int postId) {
        interactor.getPost(postId, new IPostDetailInteractor.IPostDetailCallBack() {
            @Override
            public void onSuccess(Post post) {
                if (isViewAttached()) {
                    view.getPostSuccess(post);
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
    }
}
