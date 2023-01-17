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
            <td class="game"><b>${hero.name!}</b></td>
            <td class="game"><i>${hero.heroClass!}</i></td>
            <td class="game">${hero.level!}</td>
            <td class="game">${hero.expirience!}</td>
            <td class="game">${hero.attack!}</td>
            <td class="game">${hero.defence!}</td>
            <td class="game">${hero.hitPoint!}</td>
        </tr>
        </tbody>
    </table>
    <p></p>

    <table class="div_font">
        <tbody>
        <tr>
            <td><b>На Вас напал ${monster.name}</b></td>
        </tr>
        </tbody>
    </table>
<#--    <div class="div_font"><b>На Вас напал ${monster.name}</b></div>-->
    <p></p>

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
            <td class="game"><b>${monster.name!}</b></td>
            <td class="game">${monster.level!}</td>
            <td class="game">${monster.attack!}</td>
            <td class="game">${monster.defence!}</td>
            <td class="game">${monster.hitPoint!}</td>
        </tr>
        </tbody>
    </table>
    <p></p>
    <table class="menu_way">
        <tbody>
        <tr>
            <td>
                <form action="/attackMonster/${hero.id}/${monster.id}" method="post">
                    <input type="hidden" value="Fight" name="fight">
<#--                    <input type="hidden" value=${monster.id} name="monsterId">-->
                    <button type="submit" class="button_way">Драться</button>
                </form>
            </td>
            <td>
                <form action="/attackMonster/${hero.id}/${monster.id}" method="post">
                    <input type="hidden" value="Run" name="fight">
<#--                    <input type="hidden" value=${monster.id} name="monsterId">-->
                    <button type="submit" class="button_way">Бежать</button>
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
        .div_font {
            margin: auto;
        }
        .button_way {
            width: 70px;
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