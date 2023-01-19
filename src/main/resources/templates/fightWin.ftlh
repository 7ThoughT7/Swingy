<#import "parts/common.ftlh" as c>

<style> <#include "style/style.css"> </style>

<@c.page>
    <table class="menu_table">
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
            <td class="menu_td"><b>${hero.name!}</b></td>
            <td class="menu_td"><i>${hero.heroClass!}</i></td>
            <td class="menu_td">${hero.level!}</td>
            <td class="menu_td">${hero.expirience!}</td>
            <td class="menu_td">${hero.attack!}</td>
            <td class="menu_td">${hero.defence!}</td>
            <td class="menu_td">${hero.hitPoint!}</td>
        </tr>
        </tbody>
    </table>

    <p></p>

    <table class="bar_table">
        <tbody>
        <tr>
            <td><b>Вы победили!!!</b></td>
        </tr>
        </tbody>
    </table>

    <#if armor??>
        <table class="menu_table">
            <caption><h3>Из монстра выпало</h3></caption>
            <thead>
            <tr>
                <th></th>
                <th>Атака</th>
                <th>Защита</th>
                <th>Здоровье</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="menu_td">${armor.nameArtifact}</td>
                <td class="menu_td">${armor.attack}</td>
                <td class="menu_td">${armor.defence}</td>
                <td class="menu_td">${armor.hitPoint}</td>
                <td>
                    <form action="/fightWin/${hero.id}" method="post" class="form_style">
                        <input type="hidden" value="Armor" name="equip">
                        <button type="submit" class="button_way">Взять</button>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    <#elseif helm??>
        <table class="menu_table">
            <caption><h3>Из монстра выпало</h3></caption>
            <thead>
            <tr>
                <th></th>
                <th>Атака</th>
                <th>Защита</th>
                <th>Здоровье</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="menu_td">${helm.nameArtifact}</td>
                <td class="menu_td">${helm.attack}</td>
                <td class="menu_td">${helm.defence}</td>
                <td class="menu_td">${helm.hitPoint}</td>
                <td>
                    <form action="/fightWin/${hero.id}" method="post" class="form_style">
                        <input type="hidden" value="Helm" name="equip">
                        <button type="submit" class="button_way">Взять</button>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    <#elseif weapon??>
        <table class="menu_table">
            <caption><h3>Из монстра выпало</h3></caption>
            <thead>
            <tr>
                <th></th>
                <th>Атака</th>
                <th>Защита</th>
                <th>Здоровье</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="menu_td">${weapon.nameArtifact}</td>
                <td class="menu_td">${weapon.attack}</td>
                <td class="menu_td">${weapon.defence}</td>
                <td class="menu_td">${weapon.hitPoint}</td>
                <td>
                    <form action="/fightWin/${hero.id}" method="post" class="form_style">
                        <input type="hidden" value="Weapon" name="equip">
                        <button type="submit" class="button_way">Взять</button>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </#if>

    <p></p>
    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/fight/${hero.id}" method="get">
                    <input type="hidden" value="Fight" name="but">
                    <button type="submit" class="button_way">В бой</button>
                </form>
            </td>
            <td>
                <form action="/hero/${hero.id}" method="get">
                    <input type="hidden" value="Hero" name="but">
                    <button type="submit" class="button_way">К герою</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>

</@c.page>