function validate() {
    var login = document.forms["loginForm"]["login"].value;
    var pass = document.forms["loginForm"]["pass"].value;



    var flag = true;

    if(login == ""){
        document.forms["loginForm"]["login"].style.background = "#ffccff";
        flag = false;
    }else{
        document.forms["loginForm"]["login"].style.background = "white";
    }
    if(pass == ""){
        document.forms["loginForm"]["pass"].style.background = "#ffccff";
        flag = false;
    }else{
        document.forms["loginForm"]["pass"].style.background = "white";
    }
    return flag;
}