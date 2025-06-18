@import org.svenehrke.ssfe.bds.components.greet.GreetCM;

@param GreetCM cm

@if (cm != null && cm.greetee() != null) {
<div>Hello ${cm.greetee()}</div>
}
@else {
<div>Hello world</div>
}
@endif
