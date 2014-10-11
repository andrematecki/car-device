function showDialogOnCompleteRequest(data, idDialog) {
	if (data.status == 'success' || data.status == 'complete' ) {
		var dialog = eval(idDialog);
		if (!dialog || !dialog.hide) {
			return;
		}

		dialog.show();
	}
};

function closeDialogOnCompleteRequest(data, idDialog) {
	if (data.status == 'success' || data.status == 'complete' ) {
		var dialog = eval(idDialog);
		if (!dialog || !dialog.hide) {
			return;
		}

		dialog.hide();
	}
};


function executeFunctionOnFormValidate(xhr, status, args, func) {
	if(!args || args.validationFailed) {
		return;
	}

	if (!func) {
		return;
	}

	try {
		func();
	}
	catch (e) {
	}

};

function executeFunctionOnFormNotValidate(xhr, status, args, func) {
	if (!func) {
		return;
	}

	if(!args || args.validationFailed) {
		try {
			func();
		}
		catch (e) {
		}
	}
};

function showStatus() {
	statusDialog.show();
}
function hideStatus() {
	statusDialog.hide();
}

function noAjaxStatus(){
	PrimeFaces.monitorDownload(showStatus, hideStatus);
}

function afterDialogClose(){
	// apenas para ser sobrescrito
}


// Calendar
PrimeFaces.locales['pt_BR'] = {
		closeText: 'Fechar',
		prevText: 'Anterior',
		nextText: 'Pr&oacute;ximo',
		currentText: 'Come�o',
		monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
		dayNames: ['Domingo','Segunda','Ter&ccedil;a','Quarta','Quinta','Sexta','S&aacute;bado'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S�b'],
		dayNamesMin: ['D','S','T','Q','Q','S','S'],
		weekHeader: 'Semana',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: '',
		timeOnlyTitle: 'S&oacute; Horas',
		timeText: 'Tempo',
		hourText: 'Hora',
		minuteText: 'Minuto',
		secondText: 'Segundo',
		currentText: 'Data Atual',
		ampm: false,
		month: 'M&ecirc;s',
		week: 'Semana',
		day: 'Dia',
		allDayText : 'Todo Dia'
};

function redirectAutenticao(context) {
    if( document.formLogin.msisdn.value.length <= 11  ){
            window.alert("Informe 1 MSISDN valido.");
    }else{
            window.location.href = context + '/autentica?MSISDN=' +  document.formLogin.msisdn.value;
    }
}

function redirectAutenticaoCRM(context) {
	var msisdn = document.formLogin.msisdn.value;
    if( msisdn.length <= 11  ){
        window.alert("Informe 1 MSISDN valido.");
    }else{
    	window.location.href = context + '/autentica?MSISDN=' + msisdn + '&FROM=crm&TO=repor&REDIRECT=http://www.portoconecta.com.br/crm';
    }
}

function Time()
{
	date = new Date();
	return date.getTime();
}

function redirecionaChat(formId) {

	var form = $('#'+formId);
	$(form).attr('target', 'blank');
	form.submit();
//	var fone = msisdn.replace('55', '0');
//	var fldaux7 = '0050' + fone + '0';
//	conectaURL ='https://wwws.portoseguro.com.br/atendimento-online/xwch/conectadll/conecta.dll?WSNewChatSession?calltype=CONECTA&language=PT&nome=' + nome + '&email=' + email + '&fone=' + fone + '&fldaux1=&fldaux2=S&fldaux3=&fldaux4=&fldaux7=' + fldaux7 + '&ws=2&wsparam=' + fone;
//	window.open(conectaURL,"janelaconta" + Time(),"width=700,height=600,resizable=no,toolbar=0,location=0,directories=0,status=yes,menubar=0");
}

function nextFocusOnSuccessfullRequest(currentComponentId, nextComponentId, transferOnError, args) {

	var error = args && args.validationFailed;

	if ( currentComponentId && error && !transferOnError ){
		var currentComp = document.getElementById(currentComponentId);
		if ( currentComp ){
			$(currentComp).mouseenter();
			currentComp.focus();
			return;
		}
	}

	if ( nextComponentId ){
		var nextComp = document.getElementById(nextComponentId);
		if ( nextComp ){
			nextComp.focus();
		}
	}
}

function postData(url, data)
{
	var form = $('<form></form>');
	form.hide().attr('method','post').attr('action',url);
	for (i in data)
	{
		var input = $('<input type="hidden" />').attr('name',i).val(data[i]);
		input.appendTo(form);
	}
	form.appendTo('body').submit();
}

//NOVO LAYOUT CONECTA
//VARIÁVEIS GLOBAIS
var isIpad = navigator.userAgent.match(/iPad/i) != null;
var isIpod = navigator.userAgent.match(/iPod/i) != null;
var isIphone = navigator.userAgent.match(/iPhone/i) != null;
var isMac = (navigator.appVersion.indexOf("Mac")!=-1);

var imgOn = '';
var imgOff = '';
var isPreview = false;

//FUNÇÃO DE EQUALIZAÇÃO DOS BLOCOS
function equalizeHeight(elemento){
	elemento.find(".equalize-group").each(function() {
		var auxHeight = 0;
		$(this).find('.equalize').each(function(){
			var unitHeight = $(this).innerHeight();
			if(unitHeight>auxHeight){
				auxHeight = unitHeight;
			}
		});
		$(this).find('.equalize').each(function(){
			var finalHeight = auxHeight - (($(this).css('padding-bottom').substr(0,$(this).css('padding-bottom').length-2)*1) + ($(this).css('padding-top').substr(0,$(this).css('padding-top').length-2)*1));
			$(this).height(finalHeight);
		});
	});
	elemento.find(".equalize-group-n2").each(function() {
		var auxHeight = 0;
		$(this).find('.equalize-n2').each(function(){
			var unitHeight = $(this).innerHeight();
			if(unitHeight>auxHeight){
				auxHeight = unitHeight;
			}
		});
		$(this).find('.equalize-n2').each(function(){
			var finalHeight = auxHeight - (($(this).css('padding-bottom').substr(0,$(this).css('padding-bottom').length-2)*1) + ($(this).css('padding-top').substr(0,$(this).css('padding-top').length-2)*1));
			$(this).height(finalHeight);
		});
	});
	elemento.find("*[class*=equalize-relative]").each(function() {
		var aux = $(this).attr("class").split("equalize-relative");
		var aux = aux[1].split(" ");
		eval("var parametros = " + aux[0] + ";");
		var height = $(parametros.sel).height();
		if(parametros.ajuste!=undefined){
			height+=parametros.ajuste;
		}
		$(this).height(height);
	});

}

function ajustaLayout(){
	equalizeHeight($('body'));
	$(".menu-principal .nivel3").each(function(){
		$(this).width($(this).find(".destaques").innerWidth()+$(this).find(".beneficios").innerWidth());
	});
	if($(".wrapper:first").length){
		var offsetCentro = $(".wrapper:first").offset();
		var posicaoFinalCentro = $(".wrapper:first").innerWidth()+offsetCentro.left;

		$(".menu-principal .nivel2, .menu-principal .nivel3").each(function(){
			var width = 0;
			if($(this).hasClass("nivel3")){
				$(this).addClass("rnivel3");
				destaquesWidth = 0;
				if ($(this).find(".col-destaque").length) {
					$(this).find(".col-destaque").each(function(){
						destaquesWidth += $(this).innerWidth();
					});
				}
				else{
					destaquesWidth = $(this).find(".destaques").innerWidth();
				}
				servicosWidth = $(this).find(".servicos").innerWidth();
				widthDestaquesServicos = ((servicosWidth>destaquesWidth)?servicosWidth:destaquesWidth);
				$(this).find(".destaques").width(widthDestaquesServicos);
				$(this).find(".servicos").width(widthDestaquesServicos);
				width = widthDestaquesServicos+$(this).find(".beneficios").innerWidth();
				$(this).width(width);
				$(this).removeClass("rnivel3");
			}
			else{
				$(this).addClass("rnivel2");
				$(this).find(".item-nivel2").each(function(){
					width+=$(this).innerWidth();
				});
				$(this).width(width+2);
			}
			var offset = $(this).offset();
			var posicaoFinal = width+offset.left;
			var diferenca = posicaoFinal-posicaoFinalCentro;

			if(diferenca>0){
				$(this).offset({ left: offset.left-diferenca });
			}
		});
		$(".menu-principal .nivel3").addClass("hnivel3");
		$(".menu-principal .nivel2").addClass("hnivel2");
		$(".menu-principal .nivel1").addClass("hnivel1");
		$(".menu-principal .nivel2").removeClass("rnivel2");
		$(".menu-principal .item-nivel2").addClass("hitem-nivel2");
	}
}

$(document).ready(function() {
	$('.link-page').click(function(){
        window.open(this);
        return false;
    });



	//NOVA JANELA
	$(".nova-janela").click(function(){
		window.open($(this).attr("href"), "_blank");
		return false;
	});


});

$(window).scroll(function(){
    if ($(window).scrollTop() > 104){
        $("#div_header_cont_atendente").css("top", $(window).scrollTop() - 104 + "px");
    } else {
        $("#div_header_cont_atendente").css("top", "0px");
    }
});