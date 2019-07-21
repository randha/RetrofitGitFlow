package pe.edu.cibertec.retrofitgitflow.presentation.main;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface MainContract {
    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getAllPostSuccess(List<Post> postList);
        void gotToDetailPost(int postId);
    }

    interface IPresenter{
        // las 3 sgtes funciones validan que el presentador siga activo
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        // obtener todos los post
        void getAllPost();
    }
}
