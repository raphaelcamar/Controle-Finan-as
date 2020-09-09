let loginL = document.querySelector('.form-login');
let cadastro = document.querySelector('.form-cadastro');
let btnLog = document.querySelector('#login');
let btnCad = document.querySelector('#cadastro');

btnLog.addEventListener('click', function(){
    cadastro.classList.add('none', 'left');
    loginL.classList.remove('none');
    btnLog.classList.add('borda');
    btnCad.classList.remove('borda')
})
btnCad.addEventListener('click', function(){
    cadastro.classList.remove('none');
    loginL.classList.add('none', 'right');
    btnCad.classList.add('borda');
    btnLog.classList.remove('borda');
});
