	$('#editarUsuario').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var recipientid = button.data('whatever') // Extract info from data-* attributes
		  var recipientnome = button.data('whatevernome')
		  var recipienttelefone = button.data('whatevertelefone')
		  var recipientrg = button.data('whateverrg')
		  var recipientcpf = button.data('whatevercpf')
		  var recipientdatanascimento = button.data('whateverdatanascimento')
		  var recipientcidade = button.data('whatevercidade')
		  var recipientestado = button.data('whateverestado')
		  var recipientendereco = button.data('whateverendereco')
		  var recipientcep = button.data('whatevercep')
		  var recipientestadocivil = button.data('whateverestadocivil')
		  var recipientdependencia = button.data('whateverdependencia')
		  var recipientdiabete = button.data('whateverdiabete')
		  var recipientcolesterol = button.data('whatevercolesterol')
		  var recipienthipertensao = button.data('whateverhipertensao')
		  var recipientvenerea = button.data('whatevervenerea')
		  var recipientsangue = button.data('whateversangue')
		  var recipientpeso = button.data('whateverpeso')
		  var recipientaltura = button.data('whateveraltura')
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#telefone').val(recipienttelefone)
		  modal.find('#rg').val(recipientrg)
		  modal.find('#cpf').val(recipientcpf)
		  modal.find('#data').val(recipientdatanascimento)
		  modal.find('#cidade').val(recipientcidade)
		  modal.find('#endereco').val(recipientendereco)
		  modal.find('#cep').val(recipientcep)
		  modal.find('#estado').val(recipientestado)
		  modal.find('#estadocivil').val(recipientestadocivil)
		  modal.find('#sangue').val(recipientsangue)
		  modal.find('#dependencia').val(recipientdependencia)
		  modal.find('#diabete').val(recipientdiabete)
		  modal.find('#colesterol').val(recipientcolesterol)
		  modal.find('#hipertensao').val(recipienthipertensao)
		  modal.find('#venerea').val(recipientvenerea)
		  modal.find('#altura').val(recipientaltura)
		  modal.find('#peso').val(recipientpeso)
		  
		})


	$('#editarAlergia').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientdescricao = button.data('whateverdescricao')
		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#descricao').val(recipientdescricao)
		  
		})
		
	$('#editarRemedio').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipientdescricao = button.data('whateverdescricao')
		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#descricao').val(recipientdescricao)
		  
		})
		
			
	$('#editarHospital').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipientlocalizacao = button.data('whateverlocalizacao')
		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#localizacao').val(recipientlocalizacao)
		  
		})
		
	$('#editarFarmacia').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipientlocalizacao = button.data('whateverlocalizacao')
		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#localizacao').val(recipientlocalizacao)
		  
		})
		
	$('#editarConsultaR').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipientdata = button.data('whateverdata')
		  var recipientespecialidade = button.data('whateverespecialidade')
		  var recipientdiagnostico = button.data('whateverdiagnostico')

		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#data').val(recipientdata)
		  modal.find('#diagnostico').val(recipientdiagnostico)
		  modal.find('#especialidade').val(recipientespecialidade)
		  
		})
		
	$('#editarConsultaF').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipientdata = button.data('whateverdata')
		  var recipientespecialidade = button.data('whateverespecialidade')

		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#data').val(recipientdata)
		  modal.find('#especialidade').val(recipientespecialidade)
		  
		})
		
	$('#editarContato').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipientid = button.data('whatever')
		  var recipientnome = button.data('whatevernome')
		  var recipienttelefone = button.data('whatevertelefone')
		  var recipientemail = button.data('whateveremail')

		  var modal = $(this)
		  modal.find('#id').val(recipientid)
		  modal.find('#nome').val(recipientnome)
		  modal.find('#telefone').val(recipienttelefone)
		  modal.find('#email').val(recipientemail)
		  
		})