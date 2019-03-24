let usersTable;


$(document).ready(function () {
    usersTable = $('#usersTable').DataTable({
        "autoWidth": false,
        "paging": false,
        "info": false,
        "searching": false,
        ajax: {
            url: adminPersonURL,
            dataSrc: ''
        },
        "columns": [
            // {
            //     "className":      'details-control',
            //     "orderable":      false,
            //     "data":           null,
            //     "defaultContent": ''
            // },
            {
                data: "person_name",
                width: "200px"
            },
            {
                data: "email",
                className: "text-center"
            },
            {
                data: "status",
                className: "text-center"
            }
        ],
        "order": [[1, 'asc']],
        "select": true
    });


    $('#usersTable tbody').on('click', 'td.details-control', function () {
        let tr = $(this).closest('tr');
        let row = usersTable.row( tr );

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

function updateTable() {
    $.get(adminPersonURL, function (data) {
        usersTable.clear().rows.add(data).draw();
    });
}