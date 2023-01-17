<#import "parts/common.ftlh" as c>

<@c.page>
    Персонаж
    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Класс</th>
            <th>Уровень</th>
            <th>Опыт</th>
            <th>Атака</th>
            <th>Защита</th>
            <th>Здоровье</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><b>${hero.name!}</b></td>
                <td><i>${hero.heroClass!}</i></td>
                <td>${hero.level!}</td>
                <td>${hero.expirience!}</td>
                <td>${hero.attack!}</td>
                <td>${hero.defence!}</td>
                <td>${hero.hitPoint!}</td>

            </tr>
        </tbody>
    </table>
    <p></p>
    Экипировка
    <table>
        <thead>
        <tr>
            <th>Название</th>
            <th>Увеличение атаки</th>
            <th>Увеличение защиты</th>
            <th>Увеличение здоровью</th>
        </tr>
        </thead>
        <tbody>
        <#if hero.armor??>
            <tr>
                <td>${hero.armor.nameArtifact}</td>
                <td>${hero.armor.attack}</td>
                <td>${hero.armor.defence}</td>
                <td>${hero.armor.hitPoint}</td>
            </tr>
        </#if>
        <#if hero.helm??>
            <tr>
                <td>${hero.helm.nameArtifact}</td>
                <td>${hero.helm.attack}</td>
                <td>${hero.helm.defence}</td>
                <td>${hero.helm.hitPoint}</td>
            </tr>
        </#if>
        <#if hero.weapon??>
            <tr>
                <td>${hero.weapon.nameArtifact}</td>
                <td>${hero.weapon.attack}</td>
                <td>${hero.weapon.defence}</td>
                <td>${hero.weapon.hitPoint}</td>
            </tr>
        </#if>
        </tbody>
    </table>
    <p></p>
    <form action="/hero/${hero.id}" method="post">
<#--        <input type="hidden" value="" name="heroId">-->
        <button type="submit">В бой</button>
    </form>
</@c.page>
