%a )
blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).
rot(isskogel).
schwarz(teufeltal).
start(sonnalm).
start(teufeltal).
endetIn(start, sonnalm).
endetIn(start, teufeltal).
endetIn(sonnalm, arbiskogel).
endetIn(sonnalm, vorkogel).
endetIn(arbiskogel, plattenalm).
endetIn(vorkogel, isskogel).
endetIn(plattenalm, wiesenalm).
endetIn(teufeltal, wiesenalm).
endetIn(isskogel, tal).
endetIn(wiesenalm, tal).

%b)
% endetIn(X, wiesenalm)
%X = plattenalm ;
%X = teufeltal.

%c)
gleicherStartpunkt(X, Y) :- endetIn(Z,X) , endetIn(Z,Y).

%d)
anfaengerGeeignet(X) :-blau(X), endetIn(X, tal) .
anfaengerGeeignet(X) :-blau(X), endetIn(X, Y), anfaengerGeeignet(Y).




