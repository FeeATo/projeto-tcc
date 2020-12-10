namespace TCC.Mensagens
{
    partial class frmMensagem
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            this.lblIndicador = new System.Windows.Forms.Label();
            this.btnVoltar = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.lblRedorDireito = new System.Windows.Forms.Label();
            this.btnChangeProfile = new System.Windows.Forms.Label();
            this.btnSair = new System.Windows.Forms.Label();
            this.lblNumeroMensagens = new System.Windows.Forms.Label();
            this.btnMensagens = new System.Windows.Forms.Label();
            this.btnNotas = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnEditarPrestador = new System.Windows.Forms.Label();
            this.btnEditarServico = new System.Windows.Forms.Label();
            this.btnEditarAdm = new System.Windows.Forms.Label();
            this.btnEditarUsuario = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblRedor = new System.Windows.Forms.Label();
            this.dtDisplay = new System.Windows.Forms.DataGridView();
            this.txtID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtTabelaDgv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtTituloDgv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.label2 = new System.Windows.Forms.Label();
            this.lblUsuario = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.txtTabela = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.txtTitulo = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.txtMensagem = new System.Windows.Forms.TextBox();
            this.btnPrev = new System.Windows.Forms.Button();
            this.btnNext = new System.Windows.Forms.Button();
            this.btnDeletar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).BeginInit();
            this.SuspendLayout();
            // 
            // lblIndicador
            // 
            this.lblIndicador.AutoSize = true;
            this.lblIndicador.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblIndicador.Font = new System.Drawing.Font("Kotori Rose", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIndicador.ForeColor = System.Drawing.Color.RoyalBlue;
            this.lblIndicador.Location = new System.Drawing.Point(239, 292);
            this.lblIndicador.Name = "lblIndicador";
            this.lblIndicador.Size = new System.Drawing.Size(21, 23);
            this.lblIndicador.TabIndex = 81;
            this.lblIndicador.Text = "<";
            // 
            // btnVoltar
            // 
            this.btnVoltar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnVoltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVoltar.Image = global::TCC.Properties.Resources.voltar;
            this.btnVoltar.Location = new System.Drawing.Point(99, 488);
            this.btnVoltar.Name = "btnVoltar";
            this.btnVoltar.Size = new System.Drawing.Size(119, 66);
            this.btnVoltar.TabIndex = 80;
            this.btnVoltar.Click += new System.EventHandler(this.btnVoltar_Click);
            this.btnVoltar.Paint += new System.Windows.Forms.PaintEventHandler(this.btnVoltar_Paint);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::TCC.Properties.Resources.imgNomeLogin1;
            this.pictureBox1.Location = new System.Drawing.Point(929, 46);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(179, 63);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 79;
            this.pictureBox1.TabStop = false;
            // 
            // lblRedorDireito
            // 
            this.lblRedorDireito.Location = new System.Drawing.Point(313, 23);
            this.lblRedorDireito.Name = "lblRedorDireito";
            this.lblRedorDireito.Size = new System.Drawing.Size(816, 564);
            this.lblRedorDireito.TabIndex = 78;
            this.lblRedorDireito.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedorDireito_Paint);
            // 
            // btnChangeProfile
            // 
            this.btnChangeProfile.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnChangeProfile.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnChangeProfile.Image = global::TCC.Properties.Resources.trocar_usuario_2;
            this.btnChangeProfile.Location = new System.Drawing.Point(46, 386);
            this.btnChangeProfile.Name = "btnChangeProfile";
            this.btnChangeProfile.Size = new System.Drawing.Size(224, 66);
            this.btnChangeProfile.TabIndex = 76;
            this.btnChangeProfile.Paint += new System.Windows.Forms.PaintEventHandler(this.btnChangeProfile_Paint);
            // 
            // btnSair
            // 
            this.btnSair.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSair.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSair.Image = global::TCC.Properties.Resources.turn_off_41;
            this.btnSair.Location = new System.Drawing.Point(46, 321);
            this.btnSair.Name = "btnSair";
            this.btnSair.Size = new System.Drawing.Size(224, 66);
            this.btnSair.TabIndex = 75;
            this.btnSair.Paint += new System.Windows.Forms.PaintEventHandler(this.btnSair_Paint);
            // 
            // lblNumeroMensagens
            // 
            this.lblNumeroMensagens.AutoSize = true;
            this.lblNumeroMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblNumeroMensagens.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNumeroMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.lblNumeroMensagens.Location = new System.Drawing.Point(210, 292);
            this.lblNumeroMensagens.Name = "lblNumeroMensagens";
            this.lblNumeroMensagens.Size = new System.Drawing.Size(18, 20);
            this.lblNumeroMensagens.TabIndex = 74;
            this.lblNumeroMensagens.Text = "0";
            this.lblNumeroMensagens.MouseEnter += new System.EventHandler(this.lblNumeroMensagens_MouseEnter);
            this.lblNumeroMensagens.MouseLeave += new System.EventHandler(this.lblNumeroMensagens_MouseLeave);
            // 
            // btnMensagens
            // 
            this.btnMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnMensagens.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMensagens.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnMensagens.Location = new System.Drawing.Point(48, 286);
            this.btnMensagens.Name = "btnMensagens";
            this.btnMensagens.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnMensagens.Size = new System.Drawing.Size(219, 35);
            this.btnMensagens.TabIndex = 73;
            this.btnMensagens.Text = "MENSAGENS";
            this.btnMensagens.MouseEnter += new System.EventHandler(this.btnMensagens_MouseEnter);
            this.btnMensagens.MouseLeave += new System.EventHandler(this.btnMensagens_MouseLeave);
            // 
            // btnNotas
            // 
            this.btnNotas.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnNotas.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnNotas.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNotas.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnNotas.Location = new System.Drawing.Point(48, 251);
            this.btnNotas.Name = "btnNotas";
            this.btnNotas.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnNotas.Size = new System.Drawing.Size(219, 35);
            this.btnNotas.TabIndex = 72;
            this.btnNotas.Text = "NOTAS";
            this.btnNotas.Click += new System.EventHandler(this.btnNotas_Click);
            this.btnNotas.MouseEnter += new System.EventHandler(this.btnNotas_MouseEnter);
            this.btnNotas.MouseLeave += new System.EventHandler(this.btnNotas_MouseLeave);
            // 
            // label6
            // 
            this.label6.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label6.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(46, 218);
            this.label6.Name = "label6";
            this.label6.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label6.Size = new System.Drawing.Size(224, 33);
            this.label6.TabIndex = 71;
            this.label6.Text = "MENSAGENS";
            // 
            // btnEditarPrestador
            // 
            this.btnEditarPrestador.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarPrestador.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarPrestador.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarPrestador.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarPrestador.Location = new System.Drawing.Point(48, 148);
            this.btnEditarPrestador.Name = "btnEditarPrestador";
            this.btnEditarPrestador.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarPrestador.Size = new System.Drawing.Size(219, 35);
            this.btnEditarPrestador.TabIndex = 70;
            this.btnEditarPrestador.Text = "EDITAR PRESTADOR";
            this.btnEditarPrestador.Click += new System.EventHandler(this.btnEditarPrestador_Click);
            this.btnEditarPrestador.MouseEnter += new System.EventHandler(this.btnEditarPrestador_MouseEnter);
            this.btnEditarPrestador.MouseLeave += new System.EventHandler(this.btnEditarPrestador_MouseLeave);
            // 
            // btnEditarServico
            // 
            this.btnEditarServico.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarServico.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarServico.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarServico.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarServico.Location = new System.Drawing.Point(48, 113);
            this.btnEditarServico.Name = "btnEditarServico";
            this.btnEditarServico.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarServico.Size = new System.Drawing.Size(219, 35);
            this.btnEditarServico.TabIndex = 69;
            this.btnEditarServico.Text = "EDITAR SERVIÇO";
            this.btnEditarServico.Click += new System.EventHandler(this.btnEditarServico_Click);
            this.btnEditarServico.MouseEnter += new System.EventHandler(this.btnEditarServico_MouseEnter);
            this.btnEditarServico.MouseLeave += new System.EventHandler(this.btnEditarServico_MouseLeave);
            // 
            // btnEditarAdm
            // 
            this.btnEditarAdm.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarAdm.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarAdm.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarAdm.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarAdm.Location = new System.Drawing.Point(48, 183);
            this.btnEditarAdm.Name = "btnEditarAdm";
            this.btnEditarAdm.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarAdm.Size = new System.Drawing.Size(219, 35);
            this.btnEditarAdm.TabIndex = 68;
            this.btnEditarAdm.Text = "EDITAR ADM";
            this.btnEditarAdm.Click += new System.EventHandler(this.btnEditarAdm_Click);
            this.btnEditarAdm.MouseEnter += new System.EventHandler(this.btnEditarAdm_MouseEnter);
            this.btnEditarAdm.MouseLeave += new System.EventHandler(this.btnEditarAdm_MouseLeave);
            // 
            // btnEditarUsuario
            // 
            this.btnEditarUsuario.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarUsuario.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarUsuario.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarUsuario.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarUsuario.Location = new System.Drawing.Point(48, 78);
            this.btnEditarUsuario.Name = "btnEditarUsuario";
            this.btnEditarUsuario.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarUsuario.Size = new System.Drawing.Size(219, 35);
            this.btnEditarUsuario.TabIndex = 67;
            this.btnEditarUsuario.Text = "EDITAR USUÁRIO";
            this.btnEditarUsuario.Click += new System.EventHandler(this.btnEditarUsuario_Click);
            this.btnEditarUsuario.MouseEnter += new System.EventHandler(this.btnEditarUsuario_MouseEnter);
            this.btnEditarUsuario.MouseLeave += new System.EventHandler(this.btnEditarUsuario_MouseLeave);
            // 
            // label1
            // 
            this.label1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label1.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(46, 45);
            this.label1.Name = "label1";
            this.label1.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label1.Size = new System.Drawing.Size(224, 33);
            this.label1.TabIndex = 66;
            this.label1.Text = "EDIÇÃO";
            // 
            // lblRedor
            // 
            this.lblRedor.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblRedor.Location = new System.Drawing.Point(26, 24);
            this.lblRedor.Name = "lblRedor";
            this.lblRedor.Size = new System.Drawing.Size(264, 564);
            this.lblRedor.TabIndex = 77;
            this.lblRedor.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedor_Paint);
            // 
            // dtDisplay
            // 
            this.dtDisplay.AllowUserToAddRows = false;
            this.dtDisplay.AllowUserToDeleteRows = false;
            this.dtDisplay.AllowUserToResizeColumns = false;
            this.dtDisplay.AllowUserToResizeRows = false;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dtDisplay.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
            this.dtDisplay.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtDisplay.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.txtID,
            this.txtTabelaDgv,
            this.txtTituloDgv});
            this.dtDisplay.Location = new System.Drawing.Point(699, 133);
            this.dtDisplay.Name = "dtDisplay";
            this.dtDisplay.ReadOnly = true;
            this.dtDisplay.RowHeadersWidth = 51;
            this.dtDisplay.RowTemplate.Height = 60;
            this.dtDisplay.Size = new System.Drawing.Size(409, 431);
            this.dtDisplay.TabIndex = 82;
            this.dtDisplay.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtDisplay_CellClick);
            // 
            // txtID
            // 
            this.txtID.DataPropertyName = "id";
            this.txtID.HeaderText = "ID";
            this.txtID.MinimumWidth = 6;
            this.txtID.Name = "txtID";
            this.txtID.ReadOnly = true;
            this.txtID.Width = 35;
            // 
            // txtTabelaDgv
            // 
            this.txtTabelaDgv.DataPropertyName = "qual_tabela";
            this.txtTabelaDgv.HeaderText = "Tabela";
            this.txtTabelaDgv.MinimumWidth = 6;
            this.txtTabelaDgv.Name = "txtTabelaDgv";
            this.txtTabelaDgv.ReadOnly = true;
            this.txtTabelaDgv.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.txtTabelaDgv.Width = 130;
            // 
            // txtTituloDgv
            // 
            this.txtTituloDgv.DataPropertyName = "titulo";
            this.txtTituloDgv.HeaderText = "Título";
            this.txtTituloDgv.MinimumWidth = 6;
            this.txtTituloDgv.Name = "txtTituloDgv";
            this.txtTituloDgv.ReadOnly = true;
            this.txtTituloDgv.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.txtTituloDgv.Width = 176;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 22.2F, System.Drawing.FontStyle.Bold);
            this.label2.Location = new System.Drawing.Point(334, 46);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(224, 51);
            this.label2.TabIndex = 83;
            this.label2.Text = "Mensagens";
            // 
            // lblUsuario
            // 
            this.lblUsuario.AutoSize = true;
            this.lblUsuario.BackColor = System.Drawing.Color.Transparent;
            this.lblUsuario.ForeColor = System.Drawing.Color.Black;
            this.lblUsuario.Location = new System.Drawing.Point(962, 68);
            this.lblUsuario.Name = "lblUsuario";
            this.lblUsuario.Size = new System.Drawing.Size(49, 17);
            this.lblUsuario.TabIndex = 84;
            this.lblUsuario.Text = "miguel";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(343, 133);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 20);
            this.label3.TabIndex = 85;
            this.label3.Text = "Tabela";
            // 
            // textBox1
            // 
            this.textBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBox1.Location = new System.Drawing.Point(346, 159);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.Size = new System.Drawing.Size(295, 33);
            this.textBox1.TabIndex = 86;
            // 
            // txtTabela
            // 
            this.txtTabela.BackColor = System.Drawing.SystemColors.MenuBar;
            this.txtTabela.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtTabela.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtTabela.Location = new System.Drawing.Point(352, 167);
            this.txtTabela.Name = "txtTabela";
            this.txtTabela.ReadOnly = true;
            this.txtTabela.Size = new System.Drawing.Size(272, 17);
            this.txtTabela.TabIndex = 87;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.label4.Location = new System.Drawing.Point(343, 208);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(50, 20);
            this.label4.TabIndex = 88;
            this.label4.Text = "Título";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(347, 233);
            this.textBox2.Multiline = true;
            this.textBox2.Name = "textBox2";
            this.textBox2.ReadOnly = true;
            this.textBox2.Size = new System.Drawing.Size(295, 33);
            this.textBox2.TabIndex = 89;
            // 
            // txtTitulo
            // 
            this.txtTitulo.BackColor = System.Drawing.SystemColors.MenuBar;
            this.txtTitulo.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtTitulo.Location = new System.Drawing.Point(352, 241);
            this.txtTitulo.Name = "txtTitulo";
            this.txtTitulo.ReadOnly = true;
            this.txtTitulo.Size = new System.Drawing.Size(272, 17);
            this.txtTitulo.TabIndex = 90;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.label5.Location = new System.Drawing.Point(343, 285);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(91, 20);
            this.label5.TabIndex = 91;
            this.label5.Text = "Mensagem";
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(346, 312);
            this.textBox4.Multiline = true;
            this.textBox4.Name = "textBox4";
            this.textBox4.ReadOnly = true;
            this.textBox4.Size = new System.Drawing.Size(296, 203);
            this.textBox4.TabIndex = 92;
            // 
            // txtMensagem
            // 
            this.txtMensagem.BackColor = System.Drawing.SystemColors.MenuBar;
            this.txtMensagem.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtMensagem.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtMensagem.Location = new System.Drawing.Point(352, 318);
            this.txtMensagem.Multiline = true;
            this.txtMensagem.Name = "txtMensagem";
            this.txtMensagem.ReadOnly = true;
            this.txtMensagem.Size = new System.Drawing.Size(284, 191);
            this.txtMensagem.TabIndex = 93;
            // 
            // btnPrev
            // 
            this.btnPrev.Enabled = false;
            this.btnPrev.Location = new System.Drawing.Point(451, 527);
            this.btnPrev.Name = "btnPrev";
            this.btnPrev.Size = new System.Drawing.Size(41, 37);
            this.btnPrev.TabIndex = 94;
            this.btnPrev.Text = "<";
            this.btnPrev.UseVisualStyleBackColor = true;
            this.btnPrev.Click += new System.EventHandler(this.btnPrev_Click);
            // 
            // btnNext
            // 
            this.btnNext.Enabled = false;
            this.btnNext.Location = new System.Drawing.Point(498, 527);
            this.btnNext.Name = "btnNext";
            this.btnNext.Size = new System.Drawing.Size(41, 37);
            this.btnNext.TabIndex = 95;
            this.btnNext.Text = ">";
            this.btnNext.UseVisualStyleBackColor = true;
            this.btnNext.Click += new System.EventHandler(this.btnNext_Click);
            // 
            // btnDeletar
            // 
            this.btnDeletar.Location = new System.Drawing.Point(586, 527);
            this.btnDeletar.Name = "btnDeletar";
            this.btnDeletar.Size = new System.Drawing.Size(41, 37);
            this.btnDeletar.TabIndex = 97;
            this.btnDeletar.Text = "🗑️";
            this.btnDeletar.UseVisualStyleBackColor = true;
            this.btnDeletar.Click += new System.EventHandler(this.btnDeletar_Click);
            // 
            // frmMensagem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(1155, 612);
            this.Controls.Add(this.btnDeletar);
            this.Controls.Add(this.btnNext);
            this.Controls.Add(this.btnPrev);
            this.Controls.Add(this.txtMensagem);
            this.Controls.Add(this.textBox4);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtTitulo);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtTabela);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblUsuario);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.dtDisplay);
            this.Controls.Add(this.lblIndicador);
            this.Controls.Add(this.btnVoltar);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.lblRedorDireito);
            this.Controls.Add(this.btnChangeProfile);
            this.Controls.Add(this.btnSair);
            this.Controls.Add(this.lblNumeroMensagens);
            this.Controls.Add(this.btnMensagens);
            this.Controls.Add(this.btnNotas);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnEditarPrestador);
            this.Controls.Add(this.btnEditarServico);
            this.Controls.Add(this.btnEditarAdm);
            this.Controls.Add(this.btnEditarUsuario);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblRedor);
            this.Name = "frmMensagem";
            this.Text = "frmMensagem";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblIndicador;
        private System.Windows.Forms.Label btnVoltar;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label lblRedorDireito;
        private System.Windows.Forms.Label btnChangeProfile;
        private System.Windows.Forms.Label btnSair;
        private System.Windows.Forms.Label lblNumeroMensagens;
        private System.Windows.Forms.Label btnMensagens;
        private System.Windows.Forms.Label btnNotas;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label btnEditarPrestador;
        private System.Windows.Forms.Label btnEditarServico;
        private System.Windows.Forms.Label btnEditarAdm;
        private System.Windows.Forms.Label btnEditarUsuario;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblRedor;
        private System.Windows.Forms.DataGridView dtDisplay;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblUsuario;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox txtTabela;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox txtTitulo;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.TextBox txtMensagem;
        private System.Windows.Forms.Button btnPrev;
        private System.Windows.Forms.Button btnNext;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtID;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtTabelaDgv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtTituloDgv;
        private System.Windows.Forms.Button btnDeletar;
    }
}