
function validateForm() {
	var nome = document.forms["registra"]["nome"].value;
	var cognome = document.forms["registra"]["cognome"].value;
	var email = document.forms["registra"]["email"].value;
	var password = document.forms["registra"]["password"].value;
	var matricola = document.forms["registra"]["matricola"].value;
	var cellulare = document.forms["registra"]["cellulare"].value;
	
	if (nome == "") {
    	alert("Compila il campo Nome");
		document.registra.nome.focus();
    	return false;
  	}
	if (cognome ==""){
		alert("Compila il campo Cognome");
		document.registra.cognome.focus(); 
		return false;
	}
	
	if (email ==""){
		alert("Compila il campo E-Mail");
		document.registra.email.focus(); 
		return false;
	}
	
	if (password ==""){
		alert("Compila il campo Password");
		document.registra.password.focus();
		return false;
	}
	
	if (matricola ==""){
		alert("Compila il campo Matricola");
		document.registra.matricola.focus(); 
		return false;
	}
	
	if (cellulare ==""){
		alert("Compila il campo Cellulare");
		document.registra.cellulare.focus(); 
		return false;
	}
}
