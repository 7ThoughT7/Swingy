<#import "parts/common.ftlh" as c>

<style> <#include "style/style.css"> </style>

<@c.page>

    <table class="bar_table">
        <tbody>
        <tr>
            <td>
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
            </td>
            <td></td>
            <td><b>VS</b></td>
            <td></td>
            <td>
                <table class="menu_table">
                    <thead>
                    <tr>
                        <th>Имя</th>
                        <th>Уровень</th>
                        <th>Атака</th>
                        <th>Защита</th>
                        <th>Здоровье</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="menu_td"><b>${monster.name!}</b></td>
                        <td class="menu_td">${monster.level!}</td>
                        <td class="menu_td">${monster.attack!}</td>
                        <td class="menu_td">${monster.defence!}</td>
                        <td class="menu_td">${monster.hitPoint!}</td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>

    <p></p>
    <p></p>
    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/fightMonster/${hero.id}/${monster.id}" method="post">
                    <input type="hidden" value="Attack" name="attack">
                    <button type="submit" class="button_way">Атаковать</button>
                </form>
            </td>
            <td>
                <form action="/fightMonster/${hero.id}/${monster.id}" method="post">
                    <input type="hidden" value="Next" name="attack">
                    <button type="submit" class="button_way">Пропустить</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</@c.page>