package pe.edu.cibertec.retrofitgitflow.domain.main_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IMainInteractor {

    interface IMainCallBack{
        void onSuccess(List<Post> postList);
        void onError(String errorMsg);
    }

    void getAllPost(IMainCallBack callBack);
}
