<#import "parts/common.ftlh" as c>

<@c.page>

    Создать нового персонажа
    <p></p>

    <form method="post" action="/createHero">
        <label>Имя:
            <input name="nameHero" placeholder="Ввидите имя...">
        </label>

        <label>Класс:
<#--            <#list HClass as class>-->
            <div>
                <label> <input type="checkbox" name="typeClass">Archer</label>
            </div>
            <div>
                <label> <input type="checkbox" name="typeClass">Berserk</label>
            </div>
            <div>
                <label> <input type="checkbox" name="typeClass">Wizard</label>
            </div>
<#--            </#list>-->
<#--            <button type="submit">Save</button>-->
        </label>

        <input type="hidden" value="${user.id!}" name="userId">
        <input type="submit" value="Создать">
    </form>
</@c.page>
