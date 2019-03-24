

$('#inlet_button').click(function () {
    $('div.login_form').slideToggle();
});

$(document).mouseup(function (e) {
        let login_form = $(".login_form");
        let inlet_botton = $("#inlet_button");
        if ( !login_form.is(e.target)
            && login_form.has(e.target).length === 0
            && !inlet_botton.is(e.target)) {
                $('.login_form').slideUp();
        }
});

let $content = $('#share-options').detach();


$('#reg_text').on('click',function () {
    modal.open({
        content: $content,
        width: 340,
        height: 300,
    })
});