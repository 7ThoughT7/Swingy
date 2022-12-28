<#import "parts/common.ftlh" as c>

<@c.page>

    Создать нового персонажа
    <p></p>

    <form method="post" action="/createHero">
        <label>Имя:
            <input type="text" name="nameHero" placeholder="Ввидите имя...">
        </label>
        <p></p>
        <label>Выберите класс:
            <div>
                <label> <input type="radio" name="typeClass" value="Archer">Archer</label>
            </div>
            <div>
                <label> <input type="radio" name="typeClass" value="Berserk">Berserk</label>
            </div>
            <div>
                <label> <input type="radio" name="typeClass" value="Wizard">Wizard</label>
            </div>
        </label>
        <p></p>
        <label>Выберите экипировку:
            <div>
                <label> <input type="radio" name="typeArtifact" value="Weapon">Weapon</label>
            </div>
            <div>
                <label> <input type="radio" name="typeArtifact" value="Armor">Armor</label>
            </div>
            <div>
                <label> <input type="radio" name="typeArtifact" value="Helm">Helm</label>
            </div>
        </label>

<#--        <input type="hidden" value="${user.id!}" name="userId">-->
        <input type="submit" value="Создать">
    </form>
</@c.page>
