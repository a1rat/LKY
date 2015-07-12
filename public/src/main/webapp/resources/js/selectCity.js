/**
 * Created by Rail on 07.05.2015.
 */
function sendCity() {
    var city = $('#town :selected').val();
    $.ajax({
        url: "/city",
        type: "GET",
        data: {
            town: city
        },
        success: function(data) {
        },
        error: function() {
            alert("Ошибка");
        }
    });
}