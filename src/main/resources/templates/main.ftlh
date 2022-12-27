<#import "parts/common.ftlh" as c>

<@c.page>
<h1>Welcome!</h1>

    <form action="/createHero" method="post">
        <input type="hidden" value="${user_id!}" name="userId">
        <button type="submit">Создать нового персонажа</button>
    </form>
<#--    <a href="{user_id}/createHero">Создать нового персонажа</a>-->
    <p></p>

    <div>Список персонажей:</div>
    <p></p>
    <table>
        <thead>
        <tr>
            <th>Имя персонажа</th>
<#--            <th></th>-->
<#--            <th align="left" width="100">Телефон</th>-->
<#--            <th align="left" width="100">Email</th>-->
<#--            <th align="left" width="50">Номер зачетки</th>-->
        </tr>
        </thead>
        <p></p>
        <tbody>
        <#list heroes as hero>
            <tr>
                <td><b>${hero.name!}</b></td>
<#--                <td><i>${student.address}</i></td>-->
<#--                <td><i>${student.telephone}</i></td>-->
<#--                <td><i>${student.email}</i></td>-->
<#--                <td><i>${student.countingNum}</i></td>-->
            </tr>
        <#else>
            Нет героев
        </#list>
        </tbody>
    </table>
</@c.page>
