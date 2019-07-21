package pe.edu.cibertec.retrofitgitflow.presentation.post_detail;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.presentation.main.MainContract;

public interface IPostDetailContract {
    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getPostSuccess(Post post);
    }

    interface IPresenter{
        // las 3 sgtes funciones validan que el presentador siga activo
        void attachView(IPostDetailContract.IView view);
        void detachView();
        boolean isViewAttached();
        // obtener el post
        void getPost(int postId);
    }
}
