let userRestaurantTable;


$(document).ready(function () {
    userRestaurantTable = $('#userRestaurantTable').DataTable({
        "autoWidth": false,
        "paging": false,
        "info": false,
        "searching": false,
        ajax: {
            url: userRestaurantURL,
            dataSrc: ''
        },
        "columns": [
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
            {
                data: "restaurant_name",
                width: "200px"
            },
            {
                data: "meanAssessment",
                className: "text-center"
            },
            {
                data: "id",
                render: function (da) {
                    return '<label for="1">1</label>'
                        +'<input type="radio" name="1" value="1" onclick="vote(1,'+da+')">'
                        +'<label for="2">2</label>'
                        +'<input type="radio" name="2" value="2" onclick="vote(2,'+da+')">'
                        +'<label for="3">3</label>'
                        +'<input type="radio" name="3" value="3" onclick="vote(3,'+da+')">'
                        +'<label for="4">4</label>'
                        +'<input type="radio" name="4" value="4" onclick="vote(4,'+da+')">'
                        +'<label for="5">5</label>'
                        +'<input type="radio" name="5" value="5" onclick="vote(5,'+da+')">'
                },
            }
        ],
        "order": [[1, 'asc']],
        "select": true
    });


    $('#userRestaurantTable tbody').on('click', 'td.details-control', function () {
        let tr = $(this).closest('tr');
        let row = userRestaurantTable.row( tr );

        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );


    $userModalContent = $('#user-form').detach();
});

function format (d) {
    let result = '<table class="hiddenTables">';
    d.dishes.forEach(function (element) {
        result = result
            +'<tr>'
            +'<td class="dish">'+element.dish_name+'</td>'
            +'<td class="price">'+element.dish_price+' руб.</td>'
            +'</tr>';
    });
    result += '</table>';

    return result;
}

function vote(assessment_value, id_restaurant) {
    let id_person = $('#id_person').html();
    let result = 'id=&'+'assessment_value='+assessment_value+'&id_restaurant='+id_restaurant+'&id_person='+id_person;
    $.ajax({
        type: "POST",
        url: userAssessmentURL,
        data: result,
    }).done(function () {
        updateTable();
    });
}

function updateTable() {
    $.get(userRestaurantURL, function (data) {
        userRestaurantTable.clear().rows.add(data).draw();
    });
}