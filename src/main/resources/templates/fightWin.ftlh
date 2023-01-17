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

    <table>
        <tbody>
        <tr>
            <td><b>Вы победили!!!</b></td>
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
<#--            <td>-->
<#--                <form action="/fight/${hero.id}" method="post">-->
<#--                    <input type="hidden" value="Right" name="way">-->
<#--                    <button type="submit" class="button_way">Вправо</button>-->
<#--                </form>-->
<#--            </td>-->
<#--            <td>-->
<#--                <form action="/fight/${hero.id}" method="post">-->
<#--                    <input type="hidden" value="Down" name="way">-->
<#--                    <button type="submit" class="button_way">Вниз</button>-->
<#--                </form>-->
<#--            </td>-->
        </tr>
        </tbody>
    </table>

    <style>
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
    </style>
</@c.page>