<#import "parts/common.ftlh" as c>

<style> <#include "style/style.css"> </style>

<@c.page>

    <table class="bar_table">
        <tbody>
        <tr><td class="margin_auto"><h1>Добро пожаловать в игру</h1></td></tr>
        </tbody>
    </table>

    <table class="bar_table">
        <tbody>
        <tr>
            <td class="margin_auto">
                <form action="/main" method="post" class="form_margin">
                    <button type="submit" class="button_big">Создать нового героя</button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>

    <p></p>
    <p></p>

        <table class="menu_table">
            <caption>Список героев</caption>
            <thead>
            <tr>
                <th class="menu_th">Имя</th>
                <th class="menu_th">Класс</th>
                <th></th>
            </tr>
            </thead>
            <p></p>
            <tbody>
            <#list heroes as hero>
                    <tr>
                        <td class="menu_td"><b>${hero.name!}</b></td>
                        <td class="menu_td"><i>${hero.heroClass!}</i></td>
                        <td class="menu_td">
                            <form action="/hero/${hero.id}" method="get" class="form_style">
                                <button type="submit" class="button_way">Выбрать</button>
                            </form>
                        </td>
                    </tr>
            <#else>
                <table class="menu_way">
                    <tbody>
                    <tr>
                        <td><h3>Нет героев</h3></td>
                    </tr>
                    </tbody>
                </table>
            </#list>
            </tbody>
        </table>
</@c.page>
