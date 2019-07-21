package pe.edu.cibertec.retrofitgitflow.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_interactor.IPostDetailInteractor;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_interactor.PostDetailInteractorImpl;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostPresenter;

@Module
public class PostDetailModule {

    @Provides
    IPostDetailInteractor providePostDetailInteractor(){
        return new PostDetailInteractorImpl();
    }
}
