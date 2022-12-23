<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    ВХОД
    <p></p>
    <form method="post" action="/login">
        <label>Email:
            <input type="email" name="email" placeholder="Введите email...">
        </label>
        <label>Пароль:
            <input type="password" name="password" placeholder="Введите пароль...">
        </label>
        <input type="submit" value="Регистрация">
    </form>

</@c.page>
