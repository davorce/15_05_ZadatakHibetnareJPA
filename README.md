Kreirati novi Java projekt koji će koristiti radne okvire Hibernate i JPA i implementirati primjer veze „1:N” s entitetima „Jelo” (engl. Meal) i sastojci (engl. Ingredients)
Klasa „Meal” mora sadržavati identifikator „Long id” i naziv „String name” te listu objekata klase „Ingredient” te anotaciju „@OneToMany”
Klasa „Ingredient” mora sadržavati identifikator „Long id” i naziv „String name” i objekt klase „Meal” kojem pripada taj sastojak označen s anotacijama „@ManyToOne” i „@JoinColumn”
Kreirati i glavnu klasu koja sprema objekt klase „Meal” zajedno s nekoliko sastojaka.
Napisati upit koji će dohvaćati podatke o svim jelima.


Pomoć za one to many vezu na strani Meal klase:
@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
