/**
 * Created by Гатауллин on 19.04.2015.
 */
$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: '/task/list',
        success: function (res) {
            alert(res);
        },
        error: function () {
            alert('На сервере произошла какая то ошибка!');
        }
    });

    /**
     * Поиск
     */
    $('#searchButton').click(function () {
        var searchStr = $.trim($('#searchInput').val());
        if (searchStr != '') {
            window.location = "/search?searchStr=" + searchStr;
        }
    });
});