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
    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/fight/${hero.id}" method="post">
                        <input type="hidden" value="Up" name="way">
                    <button type="submit" class="button_way">Вверх</button>
                </form>
            </td>
            <td>
                <form action="/fight/${hero.id}" method="post">
                    <input type="hidden" value="Left" name="way">
                    <button type="submit" class="button_way">Влево</button>
                </form>
            </td>
            <#list 1..hero.sizeMap as s>
                    <td id='way' width="25px" height="25px"></td>
            </#list>
            <td>
                <form action="/fight/${hero.id}" method="post">
                    <input type="hidden" value="Right" name="way">
                    <button type="submit" class="button_way">Вправо</button>
                </form>
            </td>
            <td>
                <form action="/fight/${hero.id}" method="post">
                    <input type="hidden" value="Down" name="way">
                    <button type="submit" class="button_way">Вниз</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <p></p>

    <table onClick="ChangePlace('name1','name2')" class="game_table">
        <tbody>
        <#list 1..hero.sizeMap as x>
            <tr>
                <#list 1..hero.sizeMap as y>
                    <#if x = hero.coordinateX && y = hero.coordinateY>
                        <td id='person' class="game"><img src="images/Berserk21.jpeg" width="25" height="25" class="Berserk5"/></td>
                    <#--                        <#elseif-->
                    <#else>
                        <td id='cell' class="game"></td>
                    </#if>
                </#list>
            </tr>
        </#list>
        </tbody>
    </table>

    <p></p>

    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/hero/${hero.id}" method="get">
                    <input type="hidden" value="Hero" name="but">
                    <button type="submit" class="button_way">К герою</button>
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