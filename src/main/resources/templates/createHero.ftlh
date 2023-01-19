<#import "parts/common.ftlh" as c>

<style> <#include "style/style.css"> </style>

<@c.page>

    <table class="menu_table">
        <caption><h3>Создать нового персонажа</h3><p></p></caption>

        <tbody>
        <tr>
            <td>
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
                    <p></p>
                    <input type="submit" value="Создать">
                </form>
            </td>
        </tr>
        </tbody>
    </table>

    <p></p>

    <table class="menu_way">
        <tbody>
        <tr>
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
