// JavaScript Document
function getStyle(obj,name){
	if(obj.currentStyle)
	{
		return obj.currentStyle[name];
	}
	else
	{
		return getComputedStyle(obj,false)[name];
	}
}

function getByClass(oParent,cClass)
{
	var oEle=oParent.getElementsByTagName('*');
	var aResult=[];
	for(var i=0;i<oEle.length;i++)
	{
		if(oEle[i].className==cClass)
		{
			aResult.push(oEle[i]);
		}
	}
	return aResult;
}

function getMousePosition(ev){
	var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
	var scrollLeft=document.documentElement.scrollLeft||document.body.scrollLeft;
	return {x: scrollLeft+ev.clientX,y: scrollTop+ev.clientY};
}

function addEvent(obj,ev,fn)
{
	if(obj.attachEvent)
	{
		obj.attachEvent('on'+click,fn);
	}
	else
	{
		obj.addEventListener(ev,fn,false);
	}
}

function startMove(obj,oStyle,iTarget,isEnd)
{
	clearInterval(obj.timer);
	obj.timer=setInterval(function(){
		var curStyle=0;
		if(oStyle=='opacity')
		{
			curStyle=Math.round(parseFloat(getStyle(obj,oStyle))*100);
		}
		else{
			curStyle=parseInt(getStyle(obj,oStyle));
		}
		speed=(iTarget-curStyle)/10;
		speed=speed>0?Math.ceil(speed):Math.floor(speed);
		//alert(parseInt(getStyle(obj,oStyle)));
		if(curStyle==iTarget)
		{
			clearInterval(obj.timer);
			if(isEnd){
				isEnd();		
			}
		}
		else
		{
			if(oStyle=='opacity')
			{
				obj.style.filter='alpha(opacity:'+(curStyle+speed)+')';
				obj.style.opacity=(curStyle+speed)/100;
			}
			else{
			obj.style[oStyle]=curStyle+speed+'px';
			}
		}	
	},30);

}

function Ajax(url,fnSucc,fnFaild)
{
	if(window.XMLHttpRequest)
	{
		var oAjax=new XMLHttpRequest();	
	}
	else
	{
		var oAjax=new ActiveXObject("Microsoft.XMLHttp");
	}
	oAjax.open('GET',url,true);
	oAjax.send();
	oAjax.onreadystatechange=function()
	{
		if(oAjax.readyState==4)
		{
			if(oAjax.status==200)
			{
				fnSucc();
			}
			else
			{
				if(fnFaild)
				{
			 	fnFaild(oAjax.status);//not found
				}
			}
		}		
	};	
}