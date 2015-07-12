$(document).ready(function () {

    /**
     * Проверяем существует ли город с таким alias
     */
    $('#verify_alias').click(function () {
        var alias = $.trim($('#alias').val());
        if (alias == '') {
            $('#js_result').css('color', 'red')
                .html("Поле не должно быть пустым!")
                .fadeIn(400).delay(3000).fadeOut(400);
        } else {
            $.ajax({
                type: "POST",
                url: '/test/aliasExist',
                data: {alias: alias},
                success: function (res) {
                    if (res.length > 1) {
                        $('#js_result').css('color', 'green')
                            .html("Город с таким alias уже существует!")
                            .fadeIn(400).delay(3000).fadeOut(400);
                    } else {
                        $('#js_result').css('color', 'red')
                            .html("Города с таким alias ещё не создан в БД!")
                            .fadeIn(400).delay(3000).fadeOut(400);
                    }
                },
                error: function () {
                    alert('На сервере произошла какая то ошибка!');
                }
            })
        }
    });

    /**
     * Получаем статичную html страницу
     */
    $('#help_info').click(function () {
        $('<div>').load('resources/html/help.html', function () {
            alert($(this).html());
        });
        return false;
    });

    /**
     * Подгружаем следующего по списку репетитора
     */
    $('#next_tutor').on('click', function () {
        var index = parseInt($(this).data('index'));
        $.post('/test/getTutor', {index : index})
            .done(function (data) {
//              вызывается при успешном выполнении AJAX запроса
                $('#all_tutors').append($(data).html());
                if (data.indexOf('имя') >= 0) {
                    $('#next_tutor').data('index', index + 1)
                } else {
                    $('#next_tutor').hide();
                }
            })
            .fail(function () {
//              вызывается при ошибках
                $('#next_tutor').hide();
            })
            .always(function () {
//              вызывается всегда, последним
            });
        return false;
    });
});