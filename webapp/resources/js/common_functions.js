let form;

function add (modalContent) {
    modal.open({
        content: modalContent,
        width: 340,
        height: 300,
    })
}

function save(object,url) {
    if (object.toString() === 'dish'){
        $.ajax({
            type: "POST",
            url: url,
            data: $("#dishForm").serialize() + '&id_restaurant='+tempRestID,
        }).done(function () {
            modal.close();
            updateTable();
        });
    }else if (object.toString() === 'restaurant') {
        $.ajax({
            type: "POST",
            url: url,
            data: $("#restaurantForm").serialize(),
        }).done(function () {
            modal.close();
            updateTable();
        });
    }else if (object.toString() === 'person') {
        $.ajax({
            type: "POST",
            url: url,
            data: $("#personForm").serialize(),
        }).done(function () {
            modal.close();
            updateTable();
        });
    }

}

function deleteRow(url) {
    $.ajax({
        url: url,
        type: "DELETE"
    }).done(function () {
        updateTable();
    });
}

function updateRow(url,object) {
    if (object.toString() === 'restaurant') {
        form = $restaurantModalContent;
    } else if (object.toString() === 'dish') {
        form = $dishModalContent;
    } else if (object.toString() === 'person') {
        form = $userModalContent;
    }
    $.get(url, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        modal.open({
            content: form,
            width: 340,
            height: 300,
        })
    });

}




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

function validPerson(){
    let fail = false;
    let res = $("#personForm").serializeArray();
    let name = res[1]['value'];
    let email = res[2]['value'];
    let status = res[3]['value'];
    let password = res[4]['value'];
    let repassword = res[5]['value'];

    if (name === '' || name === ' ')
        fail = 'Ведите имя пльзователя!';
    else if (email === '' || email === ' ')
        fail = 'Введите E-mail!';
    else if (emailPattern.test(email) === false)
        fail = 'Введите E-mail правильно!';
    else if (password === '' || password === ' ')
        fail = 'Введите пароль!';
    else if (password !== repassword)
        fail = 'Пароли не совпадают!';
    if (fail)
        alert(fail)
    else
        save('person',adminPersonURL)
}






