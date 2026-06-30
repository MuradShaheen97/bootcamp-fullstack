<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Debtors' Prison</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container prison">
    <h1>You are in Debtors' Prison!</h1>
    <p>You lost too much gold.</p>

    <form action="/process" method="post">
        <input type="hidden" name="place" value="reset">
        <button class="reset">Start Over</button>
    </form>
</div>

</body>
</html>