<#import "parts/common.ftlh" as c>

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

    <table>
        <tbody>
        <tr>
            <td><b>Вы проиграли!!!</b></td>
        </tr>
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


<#--    <p></p>-->

<#--    <table onClick="ChangePlace('name1','name2')" class="game_table">-->
<#--        <tbody>-->
<#--        <#list 1..hero.sizeMap as x>-->
<#--            <tr>-->
<#--                <#list 1..hero.sizeMap as y>-->
<#--                    <#if x = hero.coordinateX && y = hero.coordinateY>-->
<#--                        <td id='person' class="game"><img src="images/Berserk5.gif" width="25" height="25" class="Berserk5"/></td>-->
<#--                    &lt;#&ndash;                        <#elseif&ndash;&gt;-->
<#--                    <#else>-->
<#--                        <td id='cell' class="game"></td>-->
<#--                    </#if>-->
<#--                </#list>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->
    <style>
        .bar_table {
            margin: auto;
        }
        .button_way {
            width: 100px;
            height: 25px;
        }
        .menu_way {
            border: 0; /* Рамка вокруг таблицы */
            margin: auto;
        }
        .menu_table {
            border: 1px solid green; /* Рамка вокруг таблицы */
            margin: auto;
        }
        .game_table {
            /*width: 1000px; !* Ширина таблицы *!*/
            /*height: 1000px; !* Высота таблицы *!*/
            border: 1px solid green; /* Рамка вокруг таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
            /*table-layout: fixed; !* Ячейки фиксированной ширины *!*/
        }
        td.game {
            padding: 1px; /* Поля вокруг содержимого таблицы */
            border: 1px solid #000; /* Параметры рамки */
            width: 25px;
            height: 25px;
            overflow: hidden;
        }
        th {
            background: #afd792; /* Цвет фона */
            color: #333;  /* Цвет текста */
        }
        tbody td:hover {
            background: #f3bd48; /* Цвет фона при наведении */
            color: #fff; /* Цвет текста при наведении */
        }
        img.Berserk5 {
            width: 25px;
            height: 25px;
        }
    </style>
</@c.page>