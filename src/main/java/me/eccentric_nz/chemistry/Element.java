package me.eccentric_nz.chemistry;

import java.util.HashMap;

public enum Element {
    Hydrogen(1, "H"),
    Helium(2, "He"),
    Lithium(3, "Li"),
    Beryllium(4, "Be"),
    Boron(5, "B"),
    Carbon(6, "C"),
    Nitrogen(7, "N"),
    Oxygen(8, "O"),
    Fluorine(9, "F"),
    Neon(10, "Ne"),
    Sodium(11, "Na"),
    Magnesium(12, "Mg"),
    Aluminium(13, "Al"),
    Silicon(14, "Si"),
    Phosphorus(15, "P"),
    Sulfur(16, "S"),
    Chlorine(17, "Cl"),
    Argon(18, "Ar"),
    Potassium(19, "K"),
    Calcium(20, "Ca"),
    Scandium(21, "Sc"),
    Titanium(22, "Ti"),
    Vanadium(23, "V"),
    Chromium(24, "Cr"),
    Manganese(25, "Mn"),
    Iron(26, "Fe"),
    Cobalt(27, "Co"),
    Nickel(28, "Ni"),
    Copper(29, "Cu"),
    Zinc(30, "Zn"),
    Gallium(31, "Ga"),
    Germanium(32, "Ge"),
    Arsenic(33, "As"),
    Selenium(34, "Se"),
    Bromine(35, "Br"),
    Krypton(36, "Kr"),
    Rubidium(37, "Rb"),
    Strontium(38, "Sr"),
    Yttrium(39, "Y"),
    Zirconium(40, "Zr"),
    Niobium(41, "Nb"),
    Molybdenum(42, "Mo"),
    Technetium(43, "Tc"),
    Ruthenium(44, "Ru"),
    Rhodium(45, "Rh"),
    Palladium(46, "Pd"),
    Silver(47, "Ag"),
    Cadmium(48, "Cd"),
    Indium(49, "In"),
    Tin(50, "Sn"),
    Antimony(51, "Sb"),
    Tellurium(52, "Te"),
    Iodine(53, "I"),
    Xenon(54, "Xe"),
    Caesium(55, "Cs"),
    Barium(56, "Ba"),
    Lanthanum(57, "La"),
    Cerium(58, "Ce"),
    Praseodymium(59, "Pr"),
    Neodymium(60, "Nd"),
    Promethium(61, "Pm"),
    Samarium(62, "Sm"),
    Europium(63, "Eu"),
    Gadolinium(64, "Gd"),
    Terbium(65, "Tb"),
    Dysprosium(66, "Dy"),
    Holmium(67, "Ho"),
    Erbium(68, "Er"),
    Thulium(69, "Tm"),
    Ytterbium(70, "Yb"),
    Lutetium(71, "Lu"),
    Hafnium(72, "Hf"),
    Tantalum(73, "Ta"),
    Tungsten(74, "W"),
    Rhenium(75, "Re"),
    Osmium(76, "Os"),
    Iridium(77, "Ir"),
    Platinum(78, "Pt"),
    Gold(79, "Au"),
    Mercury(80, "Hg"),
    Thallium(81, "Tl"),
    Lead(82, "Pb"),
    Bismuth(83, "Bi"),
    Polonium(84, "Po"),
    Astatine(85, "At"),
    Radon(86, "Rn"),
    Francium(87, "Fr"),
    Radium(88, "Ra"),
    Actinium(89, "Ac"),
    Thorium(90, "Th"),
    Protactinium(91, "Pa"),
    Uranium(92, "U"),
    Neptunium(93, "Np"),
    Plutonium(94, "Pu"),
    Americium(95, "Am"),
    Curium(96, "Cm"),
    Berkelium(97, "Bk"),
    Californium(98, "Cf"),
    Einsteinium(99, "Es"),
    Fermium(100, "Fm"),
    Mendelevium(101, "Md"),
    Nobelium(102, "No"),
    Lawrencium(103, "Lr"),
    Rutherfordium(104, "Rf"),
    Dubnium(105, "Db"),
    Seaborgium(106, "Sg"),
    Bohrium(107, "Bh"),
    Hassium(108, "Hs"),
    Meitnerium(109, "Mt"),
    Darmstadtium(110, "Ds"),
    Roentgenium(111, "Rg"),
    Copernicium(112, "Cn"),
    Nihonium(113, "Nh"),
    Flerovium(114, "Fl"),
    Moscovium(115, "Mc"),
    Livermorium(116, "Lv"),
    Tennessine(117, "Ts"),
    Oganesson(118, "Og");

    private final int atomicNumber;
    private final String symbol;
    private static final HashMap<String, Element> bySymbol = new HashMap<>();
    private static final HashMap<Integer, Element> byAtomicNumber = new HashMap<>();

    Element(int atomicNumber, String symbol) {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
    }

    static {
        for (Element e : values()) {
            bySymbol.put(e.symbol, e);
            byAtomicNumber.put(e.atomicNumber, e);
        }
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public static HashMap<String, Element> getBySymbol() {
        return bySymbol;
    }

    public static HashMap<Integer, Element> getByAtomicNumber() {
        return byAtomicNumber;
    }
}
