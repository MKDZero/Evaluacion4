package cl.inacap.puntaarenas.evaluacion4;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.Snackbar;
        import android.support.design.widget.TextInputEditText;
        import android.support.design.widget.TextInputLayout;
        import android.support.v4.widget.NestedScrollView;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.AppCompatButton;
        import android.support.v7.widget.AppCompatTextView;
        import android.view.View;
        import cl.inacap.puntaarenas.evaluacion4.DatabaseHelper;
        import cl.inacap.puntaarenas.evaluacion4.Modelo.User;
        import cl.inacap.puntaarenas.evaluacion4.Validar.Validacion_ingreso;
        import cl.inacap.puntaarenas.evaluacion4.R;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    private Validacion_ingreso validacion;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        getSupportActionBar().hide();

        Ver();
        Listeners();
        Objetos();
    }


    private void Ver() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

    }

    private void Listeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }

    private void Objetos() {
        validacion = new Validacion_ingreso(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!validacion.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.mensaje_error_nombre))) {
            return;
        }
        if (!validacion.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.mensaje_error_email))) {
            return;
        }
        if (!validacion.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.mensaje_error_email))) {
            return;
        }
        if (!validacion.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.mensaje_error_contraseña))) {
            return;
        }
        if (!validacion.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_contraseña_igual))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setNombre(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setContraseña(textInputEditTextPassword.getText().toString().trim());

            databaseHelper.addUser(user);


            Snackbar.make(nestedScrollView, getString(R.string.mensaje_satisfactorio), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            Snackbar.make(nestedScrollView, getString(R.string.error_email_existente), Snackbar.LENGTH_LONG).show();
        }


    }

    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}