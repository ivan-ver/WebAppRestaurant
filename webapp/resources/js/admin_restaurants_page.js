let tempRestID;
let AdminRestaurantTable;



$(document).ready(function () {
    AdminRestaurantTable = $('#AdminRestaurantTable').DataTable({
        "autoWidth": false,
        "paging": false,
        "info": false,
        "searching": false,
        ajax: {
            url: adminRestaurantURL,
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
                className: 'restaurantName'
            },
            {
                data: "meanAssessment",
                className: "restaurantAssessment"
            },
            {
                data: "id",
                render: function (data) {
                    return '<button onclick="deleteRow('+'\''+adminRestaurantURL+data+'\''+')">'+
                        'Удалить</button>'
                },
            },
            {
                data: "id",
                render: function (data) {
                    return '<button onclick="updateRow('+'\''+adminRestaurantURL+data+'\''+',\'restaurant\')">'+
                        'Исправить</button>'
                },
            }
        ],
        "order": [[1, 'asc']],
        "select": true
    });

    $('#AdminRestaurantTable tbody').on('click', 'td.details-control', function () {
        let tr = $(this).closest('tr');
        let row = AdminRestaurantTable.row( tr );

        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );


    $restaurantModalContent = $('#restaurant-form').detach();
    $dishModalContent = $('#dish-form').detach();
    $userModalContent = $('#user-form').detach();


});


function format (d) {
    tempRestID = d.id;
    let result = '<div class = "hidden_part">';
    result += '<button id="addDish" class="addButton" onclick="add($dishModalContent)">Добавить блюдо</button>';
    result = result + '<table class="hiddenTables">';
    d.dishes.forEach(function (element) {
        result = result
            +'<tr class="dish" border="white">'
            +'<td class="dish" width="200px">'+element.dish_name+'</td>'
            +'<td class="dish" width="100">'+element.dish_price+' руб.</td>'
            +'<td class="fixed">'
            +'<button  onclick="deleteRow(' + '\''+adminDishURL+element.id+'\'' +')"><span>Удалить</span></button>'
            +'</td>'
            +'<td class="fixed">'
            +'<button onclick="updateRow(' + '\''+adminDishURL+element.id+'\'' +',\'dish\')"><span>Исправить</span></button>'
            +'</td>'
            +'</tr>';
    });
    result += '</table></div>';

    return result;
}

function updateTable() {
    $.get(adminRestaurantURL, function (data) {
        AdminRestaurantTable.clear().rows.add(data).draw();
    });
}