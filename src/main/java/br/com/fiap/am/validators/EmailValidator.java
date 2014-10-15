package br.com.fiap.am.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.fiap.am.dao.UsuarioDAO;

@FacesValidator("validator.email")
public class EmailValidator implements Validator {

	 private Pattern pattern;
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	 public EmailValidator() {
	        pattern = Pattern.compile(EMAIL_PATTERN);
	    }

	@Override
	public void validate(final FacesContext context, final UIComponent component, final Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		String msg = "";

		if(!pattern.matcher(value.toString()).matches()) {
            msg = "Email invalido";
        }
		else{
			if(new UsuarioDAO().usuarioExiste(value.toString())){
				msg = "Email ja cadastrado";
			}
		}

		if(!msg.isEmpty()){
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}
}
