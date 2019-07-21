package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import pe.edu.cibertec.retrofitgitflow.MyApplication;
import pe.edu.cibertec.retrofitgitflow.R;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.post_detail_interactor.PostDetailInteractorImpl;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostPresenter;

public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView {


    private ProgressBar progressBarDetail;
    private Post post;
    @Inject
    PostPresenter presenter;
    private TextView titulo;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        MyApplication myApplication =(MyApplication)getApplication();
        myApplication.getAppComponent().inject(this);

        int id = getIntent().getIntExtra("post_id", -1);
        if (id == -1) {
            showError("No llegó el id");
            finish();
        }
        //presenter = new PostPresenter(new PostDetailInteractorImpl());
        presenter.attachView(this);
        presenter.getPost(id);

        titulo = findViewById(R.id.textViewTitle);
        texto = findViewById(R.id.textViewText);
        progressBarDetail = findViewById(R.id.progressBarDetail);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBarDetail.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarDetail.setVisibility(View.GONE);
    }

    @Override
    public void getPostSuccess(Post post) {
        this.post = post;
        titulo.setText(post.getTitle());
        texto.setText(post.getText());

    }
}
