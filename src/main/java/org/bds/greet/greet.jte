@import org.bds.greet.GreetCM;

@param GreetCM cm = null

@if (cm != null && cm.greetee() != null)
<div>Hello ${cm.greetee()}</div>
@else
<div>Hello world</div>
@endif
