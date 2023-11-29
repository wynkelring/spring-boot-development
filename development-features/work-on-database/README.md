<b>Immutable:</b> <br>
^ org.hibernate.annotations.Immutable <br>
^ Use @Immutable on Entity/Column to protect against updates. <br>
^ Test class: ImmutableImplGuestEntryTest <br>
<br>
<b>OneToMany:</b> <br>
^ It's better to use bidirectional relation. There is fewer queries to database. <br>
<br>
<b>OneToOne:</b> <br>
^ Use @MapsId if relation is unidirectional. <br>
^ Remember to use LAZY fetching and not to use LAZY with optional = false. <br>