let submitLogin = document.querySelector('#logar');
stringNoCPF();
submitLogin.addEventListener('click', () =>{
    valoresLogin();
})


function valoresLogin(){
    let cpf = document.querySelector('#cpf').value;
    let senha = document.querySelector('#senha').value;
    enviarValores(cpf, senha);
}
function stringNoCPF(){
    let cpfListener = document.querySelector("#cpf");
    cpfListener.addEventListener('keypress', function(){
        let tamanho = cpfListener.value.length;
        if(tamanho === 3){
            cpfListener.value = cpfListener.value + '.';
        }if(tamanho === 7){
        	cpfListener.value = cpfListener.value + '.';
        }if(tamanho === 11){
        	cpfListener.value = cpfListener.value + '-';
        }
   
    })
}

function enviarValores(cpf, senha){
    let xhrLog = new XMLHttpRequest();
    xhrLog.open("POST", "logar", true);
    xhrLog.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
    xhrLog.addEventListener('load', function(){
        if(xhrLog.status == 200){
            let erros = JSON.parse(xhrLog.responseText);
            console.log(erros)
            console.log('status 200')
           if(erros.length == 0){
            	window.location.href = "telaPrincipal.jsp";
            }else{
                visibleError(erros);
            }
        }else{
            console.log(xhrLog.status);
        }
    });
    let loginValue = new Object();
    loginValue.cpf = cpf;
    loginValue.senha = senha;
    let json = JSON.stringify(loginValue);
    xhrLog.send("jsonLogin=" + json);
}

function visibleError(erro){
    let erroLogin = document.querySelector('.errosLogin');
    erroLogin.innerHTML = erro
}

function StringNoCPF(){
    let cpfListener = document.querySelector("#cpf");
    cpfListener.addEventListener('keypress', function(){
        let tamanho = cpfListener.value.length;
        if(tamanho === 3){
            cpfListener.value = cpfListener.value + '.';
        }if(tamanho === 7){
        	cpfListener.value = cpfListener.value + '.';
        }if(tamanho === 11){
        	cpfListener.value = cpfListener.value + '-';
        }
   
    })
}

