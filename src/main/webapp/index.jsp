<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to the Quest Game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
</head>
<body>
<h1 id="123" style="color:darkred;" class="text-center">Пролог</h1>
<div class="text-center" style="font-size:130%;">
    <p>Позволь мне рассказать тебе о великом человеке в спорте.</p>
    <p>Этот человек родился в бедной семье,</p>
    <p>его родители работали на нескольких работах чтобы только прокормить всех детей.</p>
    <p>он прошел путь от игры босиком в мять сделанный из мочевого пузыря быка, до финала по чемпионату мира!</p>
    <p>Тебе осталось решить хочешь ли ты попробывать повторить его путь!</p>
</div>
<h2 style="color:darkred;" class="text-center">Знакомство с экипажем</h2>
<div class="text-center" style="font-size:120%;">
    <p>Тебе предстоит веселое приключение в длинною в жизнь!</p>
    <p>На твоем пути будут встречаться великие люди</p>
    <p>и тебе предстоит принимать не простые решения</p>
    <p>порой придется хорошенько подумать как они скажутся на твоем будущем</p>
    <p>Вперед</p>
    <p>Как тебя зовут и какое имя у тебя будет на футболке?</p>
</div>
<form method="post" action="gameServlet" class="text-center" style="font-size:130%;">
    <label>Имя:
        <input type="hidden" name="nextQuestionId" value="1">
        <input type="text" name="name"><br />
    </label>
    <button class="btn btn-primary" type="submit">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>