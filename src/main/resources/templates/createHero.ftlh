<#import "parts/common.ftlh" as c>

<@c.page>



    Создать нового персонажа
    <p></p>

    <form method="post" action="/createHero">
        <label>Имя:
            <input type="text" name="nameHero" placeholder="Ввидите имя..." autofocus required>
        </label>
        <p></p>
        <label>Выберите класс:
            <div>
                <label> <input type="radio" name="typeClass" value="Archer" checked>Лучник</label>
            </div>
            <div>
                <label> <input type="radio" name="typeClass" value="Berserk">Воин</label>
            </div>
            <div>
                <label> <input type="radio" name="typeClass" value="Wizard">Маг</label>
            </div>
        </label>
        <p></p>
        <label>Выберите экипировку:
            <div>
                <label> <input type="radio" name="typeArtifact" value="Weapon" checked>Оружие</label>
            </div>
            <div>
                <label> <input type="radio" name="typeArtifact" value="Armor">Броня</label>
            </div>
            <div>
                <label> <input type="radio" name="typeArtifact" value="Helm">Шлем</label>
            </div>
        </label>

<#--        <input type="hidden" value="${user.id!}" name="userId">-->

        <input type="submit" value="Создать">
    </form>
</@c.page>
