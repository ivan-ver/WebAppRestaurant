let welcomeRestaurantTable;

$(document).ready(function () {
    welcomeRestaurantTable = $('#WelcomeRestaurantTable').DataTable({
        "autoWidth": false,
        "paging": false,
        "info": false,
        "searching": false,
        ajax: {
            url: '/getrestaurants',
            dataSrc: ''
        },
        "columns": [
            {
                className:      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": '',
            },
            {
                data: "restaurant_name",
                className: 'restaurantName'
            },
            {
                data: "meanAssessment",
                className: "restaurantAssessment"

            }
            ],
        "order": [[1, 'asc']],
        "select": true
    });

    $('#WelcomeRestaurantTable tbody').on('click', 'td.details-control', function () {
        let tr = $(this).closest('tr');
        let row = welcomeRestaurantTable.row( tr );

        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
    



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

