$('#delete-employee').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget);
		  var recipientid = button.data('whatever');
		  var modal = $(this);
		  modal.find('#inputIDEmployee').val(recipientid);
})

$('#watch-employee').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget);
		  var recipientid = button.data('whatever');
		  var recipientname = button.data('whatevername');
		  var modal = $(this);
		  modal.find('#inputIDEmployee').val(recipientid);
		  modal.find('#inputNameEmployee').val(recipientname);
})

$('#add-indicator').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget);
		  var id = button.data('id');
		  var modal = $(this);
		  modal.find('#employeeID').val(id);
})

$('#update-indicator').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget);
		  var id = button.data('id');
		  var idade = button.data('idade');
		  var setor = button.data('setor');
		  var cargo = button.data('cargo');
		  var ctt = button.data('ctt');
		  var cst = button.data('cst');
		  var adv = button.data('adv');
		  var acd = button.data('acd');
		  var modal = $(this);
		  modal.find('#employeeID').val(id);
		  modal.find('#inputIdade').val(idade);
		  modal.find('#inputCargo').val(cargo);
		  modal.find('#inputSetor').val(setor);
		  modal.find('#inputCTT').val(ctt);
		  modal.find('#inputCST').val(cst);
		  modal.find('#inputAcidentes').val(acd);
		  modal.find('#inputAdvert').val(adv);
})