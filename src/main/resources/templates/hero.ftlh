<#import "parts/common.ftlh" as c>

<style> <#include "style/style.css"> </style>

<@c.page>
    <table class="menu_table">
        <caption>Персонаж</caption>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Класс</th>
            <th>Уровень</th>
            <th>Опыт</th>
            <th>Атака</th>
            <th>Защита</th>
            <th>Здоровье</th>
            <th>Зелье +50</th>
            <th>Зелье +30</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td class="menu_td"><b>${hero.name!}</b></td>
                <td class="menu_td"><i>${hero.heroClass!}</i></td>
                <td class="menu_td">${hero.level!}</td>
                <td class="menu_td">${hero.expirience!}</td>
                <td class="menu_td">${hero.attack!}</td>
                <td class="menu_td">${hero.defence!}</td>
                <td class="menu_td">${hero.hitPoint!}</td>
                <td>
                    <form action="/hero/${hero.id}" method="post" class="form_style">
                        <input type="hidden" value="50" name="heroButton">
                        <button type="submit" class="button_way">${hero.potion50}</button>
                    </form>
                </td>
                <td>
                    <form action="/hero/${hero.id}" method="post" class="form_style">
                        <input type="hidden" value="30" name="heroButton">
                        <button type="submit" class="button_way">${hero.potion30}</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
    <p></p>

    <table class="menu_table">
        <caption>Экипировка</caption>
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
                <td class="menu_td">${hero.armor.nameArtifact}</td>
                <td class="menu_td">${hero.armor.attack}</td>
                <td class="menu_td">${hero.armor.defence}</td>
                <td class="menu_td">${hero.armor.hitPoint}</td>
            </tr>
        </#if>
        <#if hero.helm??>
            <tr>
                <td class="menu_td">${hero.helm.nameArtifact}</td>
                <td class="menu_td">${hero.helm.attack}</td>
                <td class="menu_td">${hero.helm.defence}</td>
                <td class="menu_td">${hero.helm.hitPoint}</td>
            </tr>
        </#if>
        <#if hero.weapon??>
            <tr>
                <td class="menu_td">${hero.weapon.nameArtifact}</td>
                <td class="menu_td">${hero.weapon.attack}</td>
                <td class="menu_td">${hero.weapon.defence}</td>
                <td class="menu_td">${hero.weapon.hitPoint}</td>
            </tr>
        </#if>
        </tbody>
    </table>
    <p></p>

    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/hero/${hero.id}" method="post">
                    <input type="hidden" value="Fight" name="heroButton">
                    <button type="submit" class="button_way">В бой</button>
                </form>
            </td>
            <td>
                <form action="/main" method="get">
                    <input type="hidden" value="Main" name="but">
                    <button type="submit" class="button_way">На главную</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>

</@c.page>
