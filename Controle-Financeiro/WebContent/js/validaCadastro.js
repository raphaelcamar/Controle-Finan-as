let botaoCad = document.querySelector("#cadastrar");
console.log(botaoCad);
StringNoCPF();
botaoCad.addEventListener('click', function () {
    receberDados();
    removeClassesErros();
});

function cadastrar(nome, sobrenome, senha, cpf, email) {
    let xhrCad = new XMLHttpRequest();
    xhrCad.open("POST", "cadastrar", true);
    xhrCad.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded; charset=utf-8");
    xhrCad.addEventListener("load", function () {
        if (xhrCad.status == 200) {
            let erros = JSON.parse(xhrCad.responseText);
      
            if (erros.length == 0) {
                window.location.href = "telaPrincipal.jsp";
            } else {
                erros.forEach(function (printErros) {
                    mostrarErros(printErros);
                })
            }

        } else {
            console.log(xhrCad.status);
            console.log(xhrCad.responseText);
        }
    })
    let cadastro = new Object();
    cadastro.nome = nome;
    cadastro.sobrenome = sobrenome;
    cadastro.senha = senha;
    cadastro.cpf = cpf;
    cadastro.email = email;

    let json = JSON.stringify(cadastro);
    xhrCad.send("dados=" + json);
}
function receberDados() {
    let nome = document.querySelector("#nomeCad").value;
    let sobrenome = document.querySelector("#sobrenomeCad").value;
    let senha = document.querySelector("#senhaCad").value;
    let cpf = document.querySelector("#cpfCad").value;
    let email = document.querySelector("#emailCad").value;
    cadastrar(nome, sobrenome, senha, cpf, email);
}

function mostrarErros(valorString) {
    let formulario = document.querySelector('.form-cadastro');
    let inputs = formulario.querySelectorAll('input');
    let msg_err_div = document.querySelectorAll('.mensagem-erro');
    console.log(inputs)
    if (valorString.includes('O nome')) {
        msg_err_div[0].innerHTML = valorString;
        inputs[0].classList.add('input-erro');
    }
    if (valorString.includes('O sobrenome')) {
        msg_err_div[1].innerHTML = valorString;
        inputs[1].classList.add('input-erro');
    }

    if (valorString.includes('senha')) {
        msg_err_div[2].innerHTML = valorString;
        inputs[2].classList.add('input-erro');
    }
    if (valorString.includes('CPF')) {
        msg_err_div[3].innerHTML = valorString;
        inputs[3].classList.add('input-erro');
    }
    if (valorString.includes('email')) {
        msg_err_div[4].innerHTML = valorString;
        inputs[4].classList.add('input-erro');
    }

}

function removeClassesErros() {

    let formulario = document.querySelector('.form-cadastro');
    let inputs = formulario.querySelectorAll('input');
    let msg_err_div = document.querySelectorAll('.mensagem-erro');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].classList.remove('input-erro');
        msg_err_div[i].innerHTML = "";
    }

}
function StringNoCPF() {
    let cpfListener = document.querySelector("#cpfCad");
    cpfListener.addEventListener('keypress', function () {
        let tamanho = cpfListener.value.length;
        if (tamanho === 3) {
            cpfListener.value = cpfListener.value + '.';
        } if (tamanho === 7) {
            cpfListener.value = cpfListener.value + '.';
        } if (tamanho === 11) {
            cpfListener.value = cpfListener.value + '-';
        }

    })
}
