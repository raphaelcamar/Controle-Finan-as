<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <title>Sistema Financeiro</title>
</head>

<body>
<c:choose>
		<c:when test="${logUser != null }">
    <p>Você não possui receita? </p>
    <button>Adcionar nova receita</button>
    <div class="form">
        <label for="metodoPagamento">Digite o título do gasto</label>
        <input type="text" name="metodoPagamento" id="metodoPagamento" placeholder="Ex: DÃ©bito" required="required">

        <label for="valor">Digite o valor</label>
        <input type="number" name="valor" id="valor" placeholder="Ex: 95,18" required="required">

        <label for="descricao">Digite a descricao do item</label>
        <input type="text" name="descricao" id="descricao" placeholder="Ex: Presente de aniversÃ¡rio do meu primo"
            required="required">

        <label for="data">Digite a data</label>
        <input type="text" name="data" id="data" placeholder="Ex: 14/03/2020" required="required">
        <button id="enviar">Enviar</button>
    </div>
    <div class="receitas">
        <table>
            <thead>
                <tr>
                    <td>Título</td>
                    <td>valor</td>
                    <td>descricao</td>
                    <td>data</td>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>

    </div>
    </c:when>
    <c:otherwise>
			<div class="n-logado">
				<p>Você não possui cadastro!</p>
			</div>
			<div class="opcao-deslogado">
				<a href="index.html">Cadastre-se</a>
			</div>
		</c:otherwise>
    </c:choose>
</body>
</html>